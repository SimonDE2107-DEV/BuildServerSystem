/* Copyright 2016 Acquized
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.simon.buildserversystem.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;
    private Material material;
    private int amount = 1;
    private String displayname;

    private boolean unsafeStackSize = false;

    public ItemBuilder(Material material, int amount, String displayname) {
        if (material == null) {
            material = Material.AIR;
        }
        this.item = new ItemStack(material, amount);
        this.material = material;
        if (((amount > material.getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize)) {
            amount = 1;
        }
        this.amount = amount;
        this.displayname = displayname;
    }
    @Deprecated
    public ItemBuilder setSkullOwner(String user) {
        // Validate.notNull(user, "The username is null.");
        if ((material == Material.PLAYER_HEAD)) {
            SkullMeta smeta = (SkullMeta) meta;
            smeta.setOwner(user);
            meta = smeta;
        }
        return this;
    }

    public ItemStack build() {
        item.setType(material);
        item.setAmount(amount);
        meta = item.getItemMeta();
        if (displayname != null) {
            meta.setDisplayName(displayname);
        }
        item.setItemMeta(meta);
        return item;
    }
}