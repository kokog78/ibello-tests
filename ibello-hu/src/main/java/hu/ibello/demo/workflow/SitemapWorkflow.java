package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.demo.steps.SitemapSteps;
import hu.ibello.steps.StepLibrary;

@Name("Sitemap")
public class SitemapWorkflow extends StepLibrary {

    private SitemapSteps sitemapSteps;
    private NavigationSteps navigationSteps;

    public void i_open_sitemap_page() {
        sitemapSteps.i_open_sitemap_page();
        sitemapSteps.i_am_on_sitemap_page();
    }

    public void i_verify_links() throws Exception {
        sitemapSteps.i_verify_all_links();
    }
}
