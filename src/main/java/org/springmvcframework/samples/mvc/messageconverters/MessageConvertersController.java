package org.springmvcframework.samples.mvc.messageconverters;

import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.feed.rss.Channel;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/messageconverters")
public class MessageConvertersController {

    @PostMapping("/string")
    public String readString(@RequestBody String string){
        return "Read string '" + string + "'";
    }

    @GetMapping("/string")
    public String writeString(){
        return "Wrote a string";
    }

    @PostMapping("/form")
    public String readForm(@ModelAttribute JavaBean javaBean){
        return "Read x-www-form-urlencoded: " + javaBean;
    }

    @GetMapping("/form")
    public MultiValueMap<String,String> writeForm(){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("foo","bar");
        map.add("fruit","apple");
        return map;
    }

    @PostMapping("/xml")
    public String readXml(@RequestBody JavaBean bean){
        return "Read from XML:" + bean;
    }

    @GetMapping("/xml")
    public JavaBean writeXml(){
        return new JavaBean("bar","apple");
    }

    @PostMapping("/json")
    public String readJson(@Valid @RequestBody JavaBean bean){
        return "Read from JSON: " +bean;
    }

    @GetMapping("/json")
    public JavaBean writeJson(){
        return new JavaBean("bar","apple");
    }

    @PostMapping("/atom")
    public String readFead(@RequestBody Feed feed){
        return "Read" + feed.getTitle();
    }

    @GetMapping("/atom")
    public Feed writeFeed(){
        Feed feed = new Feed();
        feed.setFeedType("atom_1.0");
        feed.setTitle("My Atom feed");
        return feed;
    }

    @PostMapping("/rss")
    public String readChannel(@RequestBody Channel channel){
        return "Read " + channel.getTitle();
    }

    @GetMapping("/rss")
    public Channel writeChannel(){
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("My RSS feed");
        channel.setDescription("Description");
        channel.setLink("http://localhost:8080/mvc-showcase/rss");
        return channel;
    }
}
