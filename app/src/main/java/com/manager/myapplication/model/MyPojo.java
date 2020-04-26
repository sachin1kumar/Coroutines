package com.manager.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class MyPojo
{
    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("avatar")
    private String avatar;

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public String getName ()
    {
        return name;
    }


    public String getId ()
    {
        return id;
    }

    public String getAvatar ()
    {
        return avatar;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [createdAt = "+createdAt+", name = "+name+", id = "+id+", avatar = "+avatar+"]";
    }
}
