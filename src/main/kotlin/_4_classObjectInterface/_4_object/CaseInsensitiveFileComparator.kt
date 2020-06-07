package _4_classObjectInterface._4_object

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(f1: File, f2: File): Int {
        return f1.path.compareTo(f2.path, ignoreCase = true)
    }
}