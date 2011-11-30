package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A human-task, e.g. 'Get the presenter a beer'.
 */
@Entity
public class Task extends Model {

   @Id
   public Long id;

   @Constraints.Required
   public String title;

   public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);
}
