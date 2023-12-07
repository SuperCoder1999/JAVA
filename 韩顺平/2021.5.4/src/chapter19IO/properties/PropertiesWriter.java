package chapter19IO.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties将properties文档写入文件
 */
public class PropertiesWriter {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建配置文件，修改配置文件内容

        Properties properties = new Properties();
        properties.setProperty("charset", "utf8");// 本质调用了put方法
        properties.put("charset", "utf8");// 在集合中学到的方法，这里键值相同，不会添加进去
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode码值
        properties.setProperty("pwd", "888888");
        /*
            Properties 父类是 Hashtable ， 底层就是Hashtable 核心方法
            public synchronized V put(K key, V value) {
                // Make sure the value is not null
                if (value == null) {
                    throw new NullPointerException();
                }

                // Makes sure the key is not already in the hashtable.
                Entry<?,?> tab[] = table;
                int hash = key.hashCode();
                int index = (hash & 0x7FFFFFFF) % tab.length;
                @SuppressWarnings("unchecked")
                Entry<K,V> entry = (Entry<K,V>)tab[index];
                for(; entry != null ; entry = entry.next) {
                    if ((entry.hash == hash) && entry.key.equals(key)) {
                        V old = entry.value;
                        entry.value = value;//如果key 存在，就替换
                        return old;
                    }
                }

                addEntry(hash, key, value, index);//如果是新k, 就addEntry
                return null;
            }

         */

        properties.store(new FileOutputStream("src\\chapter19IO\\mySql02.properties"), null);
        // null 位置是添加注释的，注释会添加在文件头部

    }
}
