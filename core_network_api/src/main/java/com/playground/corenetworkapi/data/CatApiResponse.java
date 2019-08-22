package com.playground.corenetworkapi.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class CatApiResponse {

    @Element
    @Path("data/images/image")
    public String url;
}
