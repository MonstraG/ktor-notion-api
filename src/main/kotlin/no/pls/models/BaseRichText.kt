package no.pls.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

open class BaseRichText {
    val plainText: String = ""
    val href: String = ""
    val annotations: Annotations = Annotations()
    val type: RichTextType = RichTextType.Text
}

data class RichText(
    val text: TextObject
) : BaseRichText()

data class Mention(
    val text: MentionObject,
    val database: DatabaseReference?,
    val date: LocalDateTime,
//    val user: UserReference?,
//    val page: PageReference?,
) : BaseRichText()

data class DatabaseReference(
    val id: String
)

data class Equation(
    val text: TextObject
) : BaseRichText()

enum class RichTextType {
    Text,
    Mention,
    Equation
}

data class TextObject(
    val content: String,
    val link: RichTextObjectLink
)

enum class MentionType {
    User,
    Page,
    Database,
    Date
}

data class MentionObject(
    val type: MentionType,
)

enum class RichTextTextLinkPropType {
    Url
}

data class RichTextObjectLink(
    val type: RichTextTextLinkPropType,
    val url: String
)
