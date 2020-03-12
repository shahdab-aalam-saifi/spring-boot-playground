package com.saalamsaifi.playground.springboot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Book {
  private String isbn;
  private String title;
  private List<String> authors = new ArrayList<>();

  public Book() {
    // empty
  }

  public Book(String isbn, String title, String... authors) {
    this.isbn = isbn;
    this.title = title;
    this.authors.addAll(Arrays.asList(authors));
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getAuthors() {
    return Collections.unmodifiableList(authors);
  }

  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }

  @Override
  public int hashCode() {
    return Objects.hash(authors, isbn, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Book)) {
      return false;
    }
    Book other = (Book) obj;
    return Objects.equals(authors, other.authors)
        && Objects.equals(isbn, other.isbn)
        && Objects.equals(title, other.title);
  }

  @Override
  public String toString() {
    return "Book ["
        + (isbn != null ? "isbn=" + isbn + ", " : "")
        + (title != null ? "title=" + title + ", " : "")
        + (authors != null ? "authors=" + authors : "")
        + "]";
  }
}
