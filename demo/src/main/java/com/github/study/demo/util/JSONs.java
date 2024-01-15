package com.github.study.demo.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.SneakyThrows;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.function.Consumer;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public final class JSONs {
    private static ObjectMapper defaultMapper = new ObjectMapper();

    private JSONs() {
    }

    public static ObjectMapper copyDefaultMapper() {
        return defaultMapper.copy();
    }

    public static void doWithDefaultMapper(Consumer<ObjectMapper> consumer) {
        consumer.accept(defaultMapper);
    }

    public static TypeFactory getTypeFactory() {
        return defaultMapper.getTypeFactory();
    }

    public static ObjectMapper setTypeFactory(TypeFactory f) {
        return defaultMapper.setTypeFactory(f);
    }

    public static JavaType constructType(Type t) {
        return defaultMapper.constructType(t);
    }

    public static JsonNodeFactory getNodeFactory() {
        return defaultMapper.getNodeFactory();
    }

    public static JsonFactory getFactory() {
        return defaultMapper.getFactory();
    }

    @SneakyThrows
    public static JsonNode readTree(InputStream in) {
        return defaultMapper.readTree(in);
    }

    @SneakyThrows
    public static JsonNode readTree(Reader r) {
        return defaultMapper.readTree(r);
    }

    @SneakyThrows
    public static JsonNode readTree(String content) {
        return defaultMapper.readTree(content);
    }

    @SneakyThrows
    public static JsonNode readTree(byte[] content) {
        return defaultMapper.readTree(content);
    }

    @SneakyThrows
    public static JsonNode readTree(File file) {
        return defaultMapper.readTree(file);
    }

    @SneakyThrows
    public static JsonNode readTree(URL source) {
        return defaultMapper.readTree(source);
    }

    @SneakyThrows
    public static void writeValue(JsonGenerator g, Object value) {
        defaultMapper.writeValue(g, value);
    }

    @SneakyThrows
    public static void writeTree(JsonGenerator jgen, TreeNode rootNode) {
        defaultMapper.writeTree(jgen, rootNode);
    }

    @SneakyThrows
    public static void writeTree(JsonGenerator jgen, JsonNode rootNode) {
        defaultMapper.writeTree(jgen, rootNode);
    }

    public static ObjectNode createObjectNode() {
        return defaultMapper.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return defaultMapper.createArrayNode();
    }

    @SneakyThrows
    public static <T> T treeToValue(TreeNode n, Class<T> valueType) {
        return defaultMapper.treeToValue(n, valueType);
    }

    public static <T extends JsonNode> T valueToTree(Object fromValue) {
        return defaultMapper.valueToTree(fromValue);
    }

    @SneakyThrows
    public static <T> T readValue(File src, Class<T> valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(File src, TypeReference<T> valueTypeRef) {
        return defaultMapper.readValue(src, valueTypeRef);
    }

    @SneakyThrows
    public static <T> T readValue(File src, JavaType valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(URL src, Class<T> valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(URL src, TypeReference<T> valueTypeRef) {
        return defaultMapper.readValue(src, valueTypeRef);
    }

    @SneakyThrows
    public static <T> T readValue(URL src, JavaType valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(String content, Class<T> valueType) {
        return defaultMapper.readValue(content, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        return defaultMapper.readValue(content, valueTypeRef);
    }

    @SneakyThrows
    public static <T> T readValue(String content, JavaType valueType) {
        return defaultMapper.readValue(content, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(Reader src, Class<T> valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(Reader src, TypeReference<T> valueTypeRef) {
        return defaultMapper.readValue(src, valueTypeRef);
    }

    @SneakyThrows
    public static <T> T readValue(Reader src, JavaType valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(InputStream src, Class<T> valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(InputStream src, TypeReference<T> valueTypeRef) {
        return defaultMapper.readValue(src, valueTypeRef);
    }

    @SneakyThrows
    public static <T> T readValue(InputStream src, JavaType valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(byte[] src, Class<T> valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(byte[] src, TypeReference<T> valueTypeRef) {
        return defaultMapper.readValue(src, valueTypeRef);
    }

    @SneakyThrows
    public static <T> T readValue(byte[] src, JavaType valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(DataInput src, Class<T> valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(DataInput src, JavaType valueType) {
        return defaultMapper.readValue(src, valueType);
    }

    @SneakyThrows
    public static void writeValue(File resultFile, Object value) {
        defaultMapper.writeValue(resultFile, value);
    }

    @SneakyThrows
    public static void writeValue(OutputStream out, Object value) {
        defaultMapper.writeValue(out, value);
    }

    @SneakyThrows
    public static void writeValue(DataOutput out, Object value) {
        defaultMapper.writeValue(out, value);
    }

    @SneakyThrows
    public static void writeValue(Writer w, Object value) {
        defaultMapper.writeValue(w, value);
    }

    @SneakyThrows
    public static String writeValueAsString(Object value) {
        return defaultMapper.writeValueAsString(value);
    }

    @SneakyThrows
    public static byte[] writeValueAsBytes(Object value) {
        return defaultMapper.writeValueAsBytes(value);
    }

    @SneakyThrows
    public static void writeValue(File resultFile, Object value, boolean prettyFlag) {
        if (!prettyFlag) {
            defaultMapper.writeValue(resultFile, value);
        } else {
            defaultMapper.writerWithDefaultPrettyPrinter().writeValue(resultFile, value);
        }
    }

    @SneakyThrows
    public static void writeValue(OutputStream out, Object value, boolean prettyFlag) {
        if (!prettyFlag) {
            defaultMapper.writeValue(out, value);
        } else {
            defaultMapper.writerWithDefaultPrettyPrinter().writeValue(out, value);
        }
    }

    @SneakyThrows
    public static void writeValue(DataOutput out, Object value, boolean prettyFlag) {
        if (!prettyFlag) {
            defaultMapper.writeValue(out, value);
        } else {
            defaultMapper.writerWithDefaultPrettyPrinter().writeValue(out, value);
        }
    }

    @SneakyThrows
    public static void writeValue(Writer w, Object value, boolean prettyFlag) {
        if (!prettyFlag) {
            defaultMapper.writeValue(w, value);
        } else {
            defaultMapper.writerWithDefaultPrettyPrinter().writeValue(w, value);
        }
    }

    @SneakyThrows
    public static String writeValueAsString(Object value, boolean prettyFlag) {
        if (!prettyFlag) {
            return defaultMapper.writeValueAsString(value);
        } else {
            return defaultMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        }
    }

    @SneakyThrows
    public static byte[] writeValueAsBytes(Object value, boolean prettyFlag) {
        if (!prettyFlag) {
            return defaultMapper.writeValueAsBytes(value);
        } else {
            return defaultMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(value);
        }
    }

    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return defaultMapper.convertValue(fromValue, toValueType);
    }

    public static <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        return defaultMapper.convertValue(fromValue, toValueTypeRef);
    }

    public static <T> T convertValue(Object fromValue, JavaType toValueType) {
        return defaultMapper.convertValue(fromValue, toValueType);
    }

    @SneakyThrows
    public static <T> T updateValue(T valueToUpdate, Object overrides) {
        return defaultMapper.updateValue(valueToUpdate, overrides);
    }
}
