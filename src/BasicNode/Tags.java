package BasicNode;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */
@SuppressWarnings("unused")
public enum Tags {
    //for special use
    TEXT,
    //the parts of a document
    body,
    //the elements
    h1, h2, h3, h4, h5, h6,
    span, b, i, del,
    ul, ol, li,
    blockqutoe, p,
    //divisors
    br(TYPE.EMPTY), hr(TYPE.EMPTY);

    TYPE type;
    Tags(TYPE _type){
        type=_type;
    }
    Tags(){
        type=TYPE.NORMAL;
    }
    enum TYPE{
        EMPTY,NORMAL;
    }
}
