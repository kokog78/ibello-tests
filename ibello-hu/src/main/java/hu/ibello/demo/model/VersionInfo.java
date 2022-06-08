package hu.ibello.demo.model;


import java.util.List;

public class VersionInfo {

    private String versionNumber;
    private String versionDate;
    private List<String> iconNames;
    private List<String> descriptions;

    public VersionInfo() {
    }

    public VersionInfo(String versionNumber, String versionDate, List<String> iconNames, List<String> descriptions) {
        this.versionNumber = versionNumber;
        this.versionDate = versionDate;
        this.iconNames = iconNames;
        this.descriptions = descriptions;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }
    public void setVersionDate(String versionDate) {
        this.versionDate = versionDate;
    }
    public void setIconNames(List<String> iconNames) {
        this.iconNames = iconNames;
    }
    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public String getVersionNumber() {
        return versionNumber;
    }
    public String getVersionDate() {
        return versionDate;
    }
    public List<String> getIconNames() {
        return iconNames;
    }
    public List<String> getDescriptions() {
        return descriptions;
    }

    public String getInfo(String whatToOutput) {
        switch (whatToOutput) {
            case "version": return versionNumber;
            case "date": return versionDate;
            default: return null;
        }
    }
}
