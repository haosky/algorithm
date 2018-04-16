package com.haosky.algorithm.modules;

import java.util.List;

public class SourceInfoNode {

    private PlayerSourceInfo source;
    private List<SourceInfoNode> parentSource;
    private boolean hasChild ;
    private boolean isRoot ;
    private String nodeid ;

    public void setSource( PlayerSourceInfo source){
        this.source = source;
    }

    public void setParentSource( List<SourceInfoNode> parentSource){
        this.parentSource = parentSource;
    }

    public void setHashChild( boolean hasChild){
        this.hasChild = hasChild;
    }

    public void setIsRoot( boolean isRoot){
        this.isRoot = isRoot;
    }

    public void setNodeid( String nodeid){
        this.nodeid = nodeid;
    }


    public PlayerSourceInfo getSource(){
        return this.source;
    }


    public boolean getHasChild(){
        return this.hasChild;
    }

    public boolean getIsRoot(){
        return this.isRoot;
    }

    public String getNodeid(){
        return this.nodeid;
    }

    public List<SourceInfoNode> getParentSource(){
        return this.parentSource;
    }
}
