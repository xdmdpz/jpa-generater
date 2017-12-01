package com.yf.core.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by if on 2017/12/1.
 * todo 按照规则集成此类重写判断根节点的方法 即可使用
 */
public  abstract class TreeBuilder<T extends BaseTreeEntity<T ,ID>,ID extends Serializable >{
    /**
     *
     */
    private List<T> nodes = new ArrayList<>();

    public TreeBuilder(List<T> nodes) {
        super();
        this.nodes = nodes;
    }

    /**
     * 构建JSON树形结构
     *
     * @return
     */
    public List<T> buildJSONTree(List<T> rootNodes) {
        List<T> nodeTree = buildTree(rootNodes);
        //JSONArray jsonArray = JSONArray.fromObject(nodeTree);
        return nodeTree;
    }

    /**
     * 构建树形结构
     *
     * @return
     */
    public List<T> buildTree(List<T> rootNodes) {
        List<T> treeNodes = new ArrayList<>();
        for (T rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    /**
     * 递归子节点
     *
     * @param node
     */
    public void buildChildNodes(T node) {
        List<T> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (T child : children) {
                buildChildNodes(child);
            }
            node.setClildren(children);
        }
    }

    /**
     * 获取父节点下所有的子节点
     *
     * @param
     * @param pnode
     * @return
     */
    public  List<T> getChildNodes(T pnode) {
        List<T> childNodes = new ArrayList<>();
        for (T n : nodes) {
            if (isChild((ID) pnode.getTid(),n.getPid())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    /**
     * 判断是否为根节点
     *
     * @return
     */
    public abstract boolean isRoot(T node);

    /**
     * 判断是否为子节点
     * @param id
     * @param pid
     * @return
     */
    public abstract boolean isChild(ID id,ID pid);
    /**
     * 获取集合中所有的根节点
     *
     * @param
     * @return
     */
    public List<T> getisRoots() {
        List<T> rootNodes = new ArrayList<>();
        for (T n : nodes) {
            if (isRoot(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }
}