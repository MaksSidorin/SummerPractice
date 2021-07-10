package com.example.summerpractice.spec_news

class ImageType : SpecNewsType {

   private var specImage : Int // картинка

    constructor(imageResource : Int){
        this.specImage = imageResource
    }

    public fun getSpecNewsImage(): Int {
        return this.specImage
    }
}

class HeaderType : SpecNewsType {

  private  var boldHeader : String // заголовок

    constructor(header : String){
        this.boldHeader = header
    }

    public fun getMyHead(): String {
        return this.boldHeader
    }
}

class GreyTextType : SpecNewsType {

  private  var greyText : String // серый текст

    constructor(greyText: String){
        this.greyText = greyText
    }

    public fun getMyGreyText(): String {
        return this.greyText
    }
}

class BlackTextType : SpecNewsType {

    private  var blackText : String // черный текст

    constructor(blackText: String){
        this.blackText = blackText
    }

    public fun getMyBlackText(): String {
        return this.blackText
    }
}

class BulletedTextType : SpecNewsType {

    private var bullText: String // список

    constructor(bullText: String) {
        this.bullText = bullText
    }

    public fun getMyBullText(): String {
        return this.bullText
    }

}

class ItalicTextType : SpecNewsType {

        private var italicText: String // курсивный текст

        constructor(italicText: String) {
            this.italicText = italicText
        }

        public fun getMyItalicText(): String {
            return this.italicText
        }
}

class TwoButtonsType : SpecNewsType {

    private var likeButton: Int // кнопка лайка
    private var dislikeButton: Int // кнопка дизлайка
    private var likeText: String
    private var dislikeText: String

    constructor(likeButton : Int, dislikeButton: Int, likeText: String, dislikeText: String) {
        this.likeButton = likeButton
        this.dislikeButton = dislikeButton
        this.likeText = likeText
        this.dislikeText = dislikeText

    }

    public fun getMyLikeButton(): Int {
        return this.likeButton
    }

    public fun getMyDislikeButton(): Int {
        return this.dislikeButton
    }

    public fun getMyLikeText(): String {
        return this.likeText
    }

    public fun getMyDislikeText(): String {
        return this.dislikeText
    }

}

