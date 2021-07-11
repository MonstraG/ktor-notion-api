package no.pls.adapters

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import no.pls.models.*


// https://stackoverflow.com/a/56078382/11593686
//class BaseRichTextAdapter : TypeAdapter<BaseRichText>() {
//    override fun write(out: JsonWriter, value: BaseRichText) {
//        throw UnsupportedOperationException();
//    }
//
//    // todo: uknow make it read as a specific object and stuff
//    override fun read(input: JsonReader): BaseRichText = {
//        return {
//            when (it.type) {
//                RichTextType.Text -> it as RichText
//                RichTextType.Equation -> it as Equation
//                RichTextType.Mention -> it as Mention
//            }
//        }
//    }
//}

