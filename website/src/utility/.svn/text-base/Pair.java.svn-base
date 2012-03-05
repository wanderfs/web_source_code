package utility;

import java.lang.*; 
import java.util.*; 

public class Pair<TYPEA, TYPEB> implements Comparable< Pair<TYPEA, TYPEB> > {
  protected TYPEA Key_;
  protected TYPEB Value_;

  public Pair(TYPEA key, TYPEB value) {
    Key_   = key;
    Value_ = value;
  }

  public Pair() {
  }
  
  public TYPEA getKey() {
    return Key_;
  }
  public TYPEB getValue() {
    return Value_;
  }
  public void setKey(TYPEA key) {
      this.Key_ = key;
  }

  public void setValue(TYPEB value) {
      this.Value_ = value;
  }
  
    @Override
  public String toString() {
   // System.out.println("in toString()");
    StringBuffer buff = new StringBuffer();
      buff.append("Key: ");
      buff.append(Key_);
      buff.append("\tValue: ");
      buff.append(Value_);
    return(buff.toString() );
  }
    @Override
  public int compareTo( Pair<TYPEA, TYPEB> p1 ) { 
  //  System.out.println("in compareTo()");
    if ( null != p1 ) { 
      if ( p1.equals(this) ) { 
        return 0; 
      } else if ( p1.hashCode() > this.hashCode() ) { 
            return 1;
      } else if ( p1.hashCode() < this.hashCode() ) { 
        return -1;  
      }
    }
    return(-1);
  }
  public boolean equals( Object o ) {
	  if (!(o instanceof Pair)) {
		  return false;
	  }
	  Pair<?, ?> p1 = (Pair<?, ?>) o;
 //   System.out.println("in equals()");
    if ( null != p1 ) { 
      if ( p1.Key_.equals( this.Key_ ) && p1.Value_.equals( this.Value_ ) ) { 
        return(true);
      }
    }
    return(false);
  }
  public int hashCode() { 
    int hashCode = Key_.hashCode() + (31 * Value_.hashCode());
 //   System.out.println("in hashCode() [" + Integer.toString(hashCode) + "]");
    return(hashCode);
  }
}