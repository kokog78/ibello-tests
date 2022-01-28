package hu.ibello.demo.model;

public enum ProductNames {
  EVALUATION,
  SERVER,
  ANALYZER,
  CREATOR,
  TEAM5,
  TEAM10;

  @Override
  public String toString() {
    switch (this) {
      case EVALUATION:
        return "kipróbálása";
      case SERVER:
        return "server";
      case ANALYZER:
        return "analyzer";
      case CREATOR:
        return "creator";
      case TEAM5:
        return "team 5";
      case TEAM10:
        return "team 10";
    }
    return "";
  }
}

