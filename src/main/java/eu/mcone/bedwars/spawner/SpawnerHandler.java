/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.spawner;

import java.util.ArrayList;

public class SpawnerHandler {

    private static Spawner spawner;
    private static ArrayList<Spawner> spawner_types = new ArrayList<>();

    public SpawnerHandler() {
        spawner_types.add(new SpawnerBronze());
        spawner_types.add(new SpawnerIron());
        spawner_types.add(new SpawnerGold());
    }

    public void startSpawner(int ID) {
        spawner_types.get(ID).start();
    }

    public Spawner getSpawner(int ID) {
        return spawner_types.get(ID);
    }
}
