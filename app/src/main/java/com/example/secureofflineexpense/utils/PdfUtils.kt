package com.example.secureofflineexpense.utils

import android.graphics.pdf.PdfDocument
import java.io.File
import java.io.FileOutputStream

object PdfUtils {
    fun createEmptyPdf(outFile: File): Boolean {
        val doc = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(300, 300, 1).create()
        val page = doc.startPage(pageInfo)
        doc.finishPage(page)
        FileOutputStream(outFile).use { doc.writeTo(it) }
        doc.close()
        return true
    }
}
