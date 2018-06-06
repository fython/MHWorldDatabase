package com.gatheringhallstudios.mhworlddatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gatheringhallstudios.mhworlddatabase.R
import com.gatheringhallstudios.mhworlddatabase.common.SimpleListDelegate
import com.gatheringhallstudios.mhworlddatabase.data.views.MonsterView
import com.gatheringhallstudios.mhworlddatabase.getAssetDrawable
import kotlinx.android.synthetic.main.listitem_monster.view.*

class MonsterAdapterDelegate(private val onSelected: (MonsterView) -> Unit)
    : SimpleListDelegate<MonsterView, View>() {

    override fun getDataClass() = MonsterView::class

    override fun onCreateView(parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(R.layout.listitem_monster, parent, false)
    }

    override fun bindView(view: View, data: MonsterView) {
        val ctx = view.context
        val icon = ctx.getAssetDrawable(data.data.icon)

        view.monster_icon.setImageDrawable(icon)
        view.monster_name.text = data.name

        view.setOnClickListener { onSelected(data) }
    }
}