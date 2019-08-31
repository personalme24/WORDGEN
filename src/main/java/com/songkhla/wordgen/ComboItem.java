/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

/**
 *
 * @author Computer
 */
public class ComboItem {
    
    private String key;
    private String value;

    public ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
    public boolean equals(Object o) {
 
		// null check
		if (o == null) {
			return false;
		}
 
		// this instance check
		if (this == o) {
			return true;
		}
 
		// instanceof Check and actual value check
		if ((o instanceof ComboItem) && (((ComboItem) o).getValue() == this.value)) {
			return true;
		} else {
			return false;
		}
	}
 
//	@Override
//	public int hashCode() {
//		int result = 0;
//		result = (int) (value / 11);
//		return result;
//	}

}
