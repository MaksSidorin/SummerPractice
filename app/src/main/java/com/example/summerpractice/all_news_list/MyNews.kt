package com.example.summerpractice.all_news_list

class MyNews {

    // класс новостей
    var text = "" // текст
    var date = "" // дата публикации
    var newsImag : Int // картинка
    var SizeNews : Int

    constructor(text : String, date : String, imageResource : Int, size : Int){
        this.text = text
        this.date = date
        this.newsImag = imageResource
        this.SizeNews = size
    }

    public fun getMyText(): String {
        return this.text;
    }

    public fun setMyText(text : String) {
        this.text = text;
    }

    public fun getMyDate(): String {
        return this.date;
    }

    public fun setMyDate(date: String) {
        this.date = date;
    }

    public fun getMyImage(): Int {
        return this.newsImag;
    }

    public fun setMyImage(imageResource: Int) {
        this.newsImag = imageResource;
    }
}