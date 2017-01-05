package tingo.core.tree;

import org.apache.commons.lang3.StringUtils;

import javax.xml.soap.Node;

/**
 * Created by tengfei on 17/1/5.
 * 二叉查找树
 */
public class BSTTest {
    public static void main(String[] args) {

    }

    public Node selectBst(String key) {
        Node root = null;
        while(true) {
            if(null == root) {
                break;
            }

            if(StringUtils.equals(root.getValue(),key)) {
                return root;
            }

            if(key.compareTo(root.getValue())<0) {
//                root = root.left
            }
        }
        return null;
    }
}
