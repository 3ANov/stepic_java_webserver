package resourceServer;

import resources.Resource;

public class ResourceServer implements ResourceServerI {

    Resource resource;

    @Override
    public void addNewResource(String path) {

    }

    @Override
    public void removeResource() {
            resource = null;
    }

    @Override
    public Resource getResource() {
        return resource;
    }

    public String getResourceName() {
        return resource.getName();
    }
    public int getResourceAge() {
        return resource.getAge();
    }
}
