package dao;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {

    public static void main(String[] args) {
        //��Դ������(����+myproperties)i18n/resourse/myproperties.properties
        String basename = "i18n.resourse.myproperties";
        //�������Ի���
        Locale cn = Locale.CHINA;//����
        Locale us = Locale.US;//Ӣ��
        //���ݻ��������Ի������ض�Ӧ��������Դ�ļ�
        ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename,cn);//����myproperties_zh.properties
        ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename,us);//����myproperties_en.properties
        
        //������Դ�ļ��� ����Ϳ��Ե���ResourceBundleʵ������� getString������ȡָ������Դ��Ϣ��������Ӧ��ֵ��
        //String value =  myResources.getString(��key");
        String usernameCN = myResourcesCN.getString("username");
        String passwordCN = myResourcesCN.getString("password");
        
        String usernameUS = myResourcesUS.getString("username");
        String passwordUS = myResourcesUS.getString("password");
        
        System.out.println(usernameCN+"--"+passwordCN);
        System.out.println(usernameUS+"--"+passwordUS);
    }
}