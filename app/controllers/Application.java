package controllers;

import play.*;
import play.mvc.*;

import views.html.index;
import views.html.template;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }
    
    public Result template() {
        return ok(template.render());
    }

}
