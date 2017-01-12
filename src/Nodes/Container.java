package Nodes;

/**
 * Created by kiwid on 2017/1/12.
 */
public interface Container extends Node{
    public <T> T appendChild(Node n);
}
