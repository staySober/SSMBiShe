package com.bishe.yuanye.entity;

import java.util.Arrays;

/**
 * Created by sober on 2017/4/13.
 */
public class User {

	private Type type;

	private String username;

	private String password;

	public enum Type{

		Student(1),

		Admin(2);

		  int _value;

          public int value(){
             return _value;
          }

          Type(int value){
              _value = value;
          }

         public static Type getType(int _value)
         {
            Type[] types = Type.values();
            return Arrays.stream(types)
                    .filter(type -> type.value() == _value)
                    .findAny().get();
         }
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}


