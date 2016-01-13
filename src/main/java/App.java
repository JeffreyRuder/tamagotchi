import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/makenew", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      request.session().attribute("name", name);
      model.put("name", request.session().attribute("name"));
      model.put("template", "templates/makenew.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/activities", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Tamagotchi userTamagotchi = request.session().attribute("userTamagotchi");

      if (userTamagotchi == null) {
        String name = request.session().attribute("name");
        userTamagotchi = new Tamagotchi(name);
        request.session().attribute("userTamagotchi", userTamagotchi);
      }

      model.put("userTamagotchi", request.session().attribute("userTamagotchi"));
      model.put("template", "templates/activities.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/confirmation", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      boolean feed = false;
      boolean sleep = false;
      boolean play = false;
      boolean check = false;

      Tamagotchi userTamagotchi = request.session().attribute("userTamagotchi");

      if (userTamagotchi.isDead()) {
        userTamagotchi.cancelTimer();
      }

      String userAction = request.queryParams("activity");

      if (userAction.equals("food")) {
        userTamagotchi.addFood();
        feed = true;
      } else if (userAction.equals("sleep")) {
        userTamagotchi.addSleep();
        sleep = true;
      } else if (userAction.equals("play")) {
        userTamagotchi.addFun();
        play = true;
      } else {
        check = true;
      }

      request.session().attribute("userTamagotchi", userTamagotchi);

      model.put("feed", feed);
      model.put("sleep", sleep);
      model.put("play", play);
      model.put("check", check);

      model.put("userTamagotchi", request.session().attribute("userTamagotchi"));
      model.put("template", "templates/confirmation.vtl");

      if (userTamagotchi.isDead()) {
        request.session().removeAttribute("userTamagotchi");
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
