package hu.ibello.demo.model;

import hu.ibello.data.Model;

import java.util.List;

@Model
public class LanguageDetail {

    public List<Detail> languageDetails;

    public class Detail {
        private String language;
        private String versionPrefix;

        public String getLanguage() {
            return this.language;
        }
        public String getVersionPrefix() {
            return this.versionPrefix;
        }
    }
}
