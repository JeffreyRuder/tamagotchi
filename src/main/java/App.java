import java.util.ArrayList;
import java.util.HashMap;

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
  }
}
