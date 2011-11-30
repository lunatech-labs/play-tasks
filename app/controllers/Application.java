package controllers;

import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.helper.form;
import views.html.index;

import java.util.List;

public class Application extends Controller {

   public static Result index() {
      return ok(index.render(tasks(), form(Task.class)));
   }

   private static List<Task> tasks() {
      return Task.find.orderBy("title").findList();
   }

   public static Result delete(final Long id) {
      Task.find.ref(id).delete();
      return redirect(routes.Application.index());
   }

   public static Result add() {
      final Form<Task> taskForm = form(Task.class).bindFromRequest();
      if(taskForm.hasErrors()) {
          return badRequest(index.render(tasks(), taskForm));
      } else {
         taskForm.get().save();
         return index();
      }
   }
}