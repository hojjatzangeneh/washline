package com.app.bushehrshoo.bushehrshoo

public  class Hero {
    private var name: String = ""
        get() = this.name;
        set;
    private var realname: String = ""
        get() = this.realname;
        set;
    private var team: String = ""
        get() = this.team;
        set;
    private var firstappearance: String = ""
        get() = this.firstappearance;
        set;
    private var createdby: String = ""
        get() = this.createdby;
        set;
    private var publisher: String = ""
        get() = this.publisher;
        set;
    private var imageurl: String = ""
        get() = this.imageurl;
        set;
    private var bio: String = ""
        get() = this.bio;
        set;

    constructor(name: String, realname: String, team: String, firstappearance: String, createdby: String, publisher: String, imageurl: String, bio: String) {
        this.name = name
        this.realname = realname
        this.team = team
        this.firstappearance = firstappearance
        this.createdby = createdby
        this.publisher = publisher
        this.imageurl = imageurl
        this.bio = bio
    }
}