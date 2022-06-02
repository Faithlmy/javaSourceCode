package com.spring;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.xml.BeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.w3c.dom.Document;

public class DefaultBeanDefinitionDocumentReader implements BeanDefinitionDocumentReader {
    @Override
    public void registerBeanDefinitions(Document document, XmlReaderContext xmlReaderContext) throws BeanDefinitionStoreException {

    }
}
