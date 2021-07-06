package com.example.totalrecallkotlin.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AcceptDialogFragment : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var builder = AlertDialog.Builder(it)
            builder.setTitle("Ты че, охуел?")
                .setMessage("Отправить сообщение?")
                .setPositiveButton("Да") {
                    dialog, id -> dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity is null")
    }

}
