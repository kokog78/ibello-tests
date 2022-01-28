package hu.ibello.demo.model;

public enum Languages {

    ENGLISH,
    HUNGARIAN;

    @Override
    public String toString() {
        switch (this) {
            case ENGLISH:
                return "english";
            case HUNGARIAN:
                return "hungarian";
        }
        return "";
    }
}
