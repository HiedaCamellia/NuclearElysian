package org.hiedacamellia.nuclearelysian.datagenerator;

public enum LangName {
    EN_US("en_us"),
    ZH_CN("zh_cn");

    private final String value;

    LangName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
