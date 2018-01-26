package io.pivotal.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {

  @Id
  private Long id;

  private String text;

  public Greeting() { }

  public Greeting(Long id, String text) {
    this.id = id;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return "Greeting [id=" + id + ", text=" + text + "]";
  }

}
