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
        return "evaluation";
      case SERVER:
        return "server";
      case ANALYZER:
        return "analyzer";
      case CREATOR:
        return "creator";
      case TEAM5:
        return "team5";
      case TEAM10:
        return "team10";
    }
    return "";
  }
  public ProductNames getEvaluation (){
    return EVALUATION;
  }
}

