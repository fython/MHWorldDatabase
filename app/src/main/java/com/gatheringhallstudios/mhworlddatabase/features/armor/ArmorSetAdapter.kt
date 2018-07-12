package com.gatheringhallstudios.mhworlddatabase.features.armor

import com.gatheringhallstudios.mhworlddatabase.R
import com.gatheringhallstudios.mhworlddatabase.assets.AssetLoader
import com.gatheringhallstudios.mhworlddatabase.data.types.ArmorType
import com.gatheringhallstudios.mhworlddatabase.data.views.ArmorView
import com.gatheringhallstudios.mhworlddatabase.data.views.ArmorSetView
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.listitem_armorset_armor.*
import kotlinx.android.synthetic.main.listitem_armorset_header.*


/**
 * Header item for collapsible armor sets
 */
class ArmorSetHeaderItem(val armorSet: ArmorSetView) : Item(), ExpandableItem {
    private lateinit var group: ExpandableGroup

    override fun getLayout() = R.layout.listitem_armorset_header

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        group = onToggleListener
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val loader = AssetLoader(viewHolder.itemView.context)
        val icon = loader.loadArmorIcon(ArmorType.CHEST, armorSet.armor.first().rarity)
        viewHolder.set_icon.setImageDrawable(icon)
        viewHolder.armor_set_name.text = armorSet.armorset_name

        viewHolder.itemView.setOnClickListener {
            group.onToggleExpanded()
        }
    }
}

/**
 * Body item for collapsible armor sets.
 * Each one represents a single armor in an armor set.
 */
class ArmorSetDetailItem(val armor: ArmorView): Item() {
    override fun getLayout() = R.layout.listitem_armorset_armor

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.armor_name.text = armor.name

        val loader = AssetLoader(viewHolder.itemView.context)
        val icon = loader.loadArmorIcon(armor.armor_type, armor.rarity)
        viewHolder.armor_icon.setImageDrawable(icon)
    }
}