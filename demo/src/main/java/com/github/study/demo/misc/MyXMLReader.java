package com.github.study.demo.misc;

import com.google.common.collect.Lists;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class MyXMLReader {
    public static void main(String arge[]) throws IOException, ParseException {
        LinkedList<Blog> blogList = Lists.newLinkedList();
        try {
            File f = new File("blogs.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            NodeList blogs = doc.getElementsByTagName("item");
            for (int i = 0; i < blogs.getLength(); i++) {
                Blog dest = new Blog();
                blogList.add(dest);
                Node blog = blogs.item(i);
                NodeList blogNodes = blog.getChildNodes();
                for (int c = 0; c < blogNodes.getLength(); c++) {
                    Node attrNode = blogNodes.item(c);
                    if (attrNode.getNodeName().equals("title")) {
                        dest.title = attrNode.getTextContent();
                    }
                    if (attrNode.getNodeName().equals("link")) {
                        dest.link = attrNode.getTextContent();
                    }
                    if (attrNode.getNodeName().equals("pubDate")) {
                        dest.pubDate = attrNode.getTextContent();
                    }
                    if (attrNode.getNodeName().equals("description")) {
                        dest.content = attrNode.getTextContent();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < blogList.size(); i++) {
            Blog it = blogList.get(i);
            String xml = it.toXml();
            System.out.println(xml);

            Files.write(Paths.get("blog", i + ".enex"), xml.getBytes(StandardCharsets.UTF_8));
        }

    }

    static class Blog {
        private String title;
        private String pubDate;
        private String link;
        private String content;
        static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);

        public String toXml() throws UnsupportedEncodingException, ParseException {
            Date date = dateFormat.parse(pubDate);
            String timett = date.toInstant().atOffset(ZoneOffset.UTC)
                    .format(DateTimeFormatter.ISO_INSTANT);
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE en-export SYSTEM \"http://xml.evernote.com/pub/evernote-export2.dtd\">\n" +
                    "<en-export export-date=\"20210519T170149Z\" application=\"Evernote/Windows\" version=\"6.x\">\n" +
                    "    <note>\n" +
                    "        <title>" + title + "</title>\n" +
                    "        <content><![CDATA[<!DOCTYPE en-note SYSTEM 'http://xml.evernote.com/pub/enml2.dtd'><en-note><center style='display:none !important;visibility:collapse !important;height:0 !important;white-space:nowrap;width:100%;overflow:hidden'>" +
                    URLEncoder.encode(content, StandardCharsets.UTF_8.displayName()).replaceAll("\\+", "%20") +
                    "</center></en-note>]]></content>\n" +
                    "        <created>" + timett + "</created>\n" +
                    "        <updated>" + timett + "</updated>\n" +
                    "        <note-attributes>\n" +
                    "            <author>羊羽</author>\n" +
                    "            <source>desktop.win</source>\n" +
                    "            <source-application>yinxiang.win32</source-application>\n" +
                    "            <content-class>yinxiang.markdown</content-class>\n" +
                    "        </note-attributes>\n" +
                    "    </note>\n" +
                    "</en-export>";
        }

        @Override
        public String toString() {
            return "Blog{" +
                    "title='" + title + '\'' +
                    ", pubDate='" + pubDate + '\'' +
                    ", link='" + link + '\'' +
                    '}';
        }
    }
}