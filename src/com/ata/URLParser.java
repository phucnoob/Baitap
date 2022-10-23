package com.ata;

/**
 * For learning, this is great, but remember url are very hard concept with hundreds line of specifications
 * Just use the built-in java.net.URI in other cases.
 */
public class URLParser {

    /**
     * Get protocol of an url
     * @param url url as String
     * @return the protocol, like ftp for https...
     */
    public String getProtocol(String url) {

        // substring - cut a part of string from begin(inclusive) to end(exclusive)
        // or in math, it's [begin, end)
        // we will find the index of ':' in the url, like https://google.com, cut from begin to that
        return url.substring(0, url.indexOf(':'));
    }

    public String getHostName(String url) {
        // https://google.com/some-path
        // we want the host google.com right?, first cut from the :// first
        // it return index of ':' in ://google.com so we need to + 3 (the length of ://)
        // so begin is the index of 'g' (in google.com)
        // how about the end? just find the first slash from begin(not from 0), because it will
        // match '/', in ://, not what we want. So I use .indexOf("string", beginIndex) (built-in in java)
        int begin = url.indexOf("://") + "://".length();
        return url.substring(begin, url.indexOf('/', begin));
    }

    public String getPath(String url) {
        // the begin works as above, I won't explain again.
        // int .substring(beginIndex), it will cut from begin to end.
        // At this point you may ask,
        // there are so many variants of .substring and .begin?
        // how to remember and use them?,
        // 1. well this are method from java publisher to make our life
        // easier, so we don't have to write every thing. Besides, they are written by very experience dev
        // it's just the best just use them (with care).
        // 2. They are from the java docs, have to learn them. Google thing like "Java String method".
        // They are not very important for learning as now, but at some point you can't build anything
        // meaningful without use other people's code.

        int begin = url.indexOf("://") + "://".length();
        return url.substring(url.indexOf('/', begin));
    }

    public static void main(String[] args) {
        URLParser urlParser = new URLParser();
        String url = "https://stackoverflow.com/questions/9607903/get-domain-name-from-given-url";
        System.out.println(urlParser.getProtocol(url));
        System.out.println(urlParser.getHostName(url));
        System.out.println(urlParser.getPath(url));
    }
}
