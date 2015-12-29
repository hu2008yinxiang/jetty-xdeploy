package ian.hu.jetty.deploy.providers;

import org.eclipse.jetty.deploy.App;
import org.eclipse.jetty.deploy.providers.WebAppProvider;
import org.eclipse.jetty.server.handler.ContextHandler;


public class XWebAppProvider extends WebAppProvider {

    /**
     * Additional prefix for all context
     */
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        prefix = prefix.replaceAll("/+$", "");
        prefix = prefix.replaceAll("/{2,}", "/");
        if (prefix.charAt(0) != '/') {
            prefix = "/" + prefix;
        }
        this.prefix = prefix;
    }

    @Override
    public ContextHandler createContextHandler(App app) throws Exception {
        ContextHandler handler = super.createContextHandler(app);
        if (this.prefix != null) {
            handler.setContextPath(this.prefix + handler.getContextPath());
        }
        return handler;
    }
}
