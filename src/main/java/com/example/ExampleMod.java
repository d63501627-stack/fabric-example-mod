package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("my-mod");

    @Override
    public void onInitialize() {
        LOGGER.info("Мод с командами запущен!");

        // Регистрируем команду /testmod
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("testmod")
                .executes(context -> {
                    // Это сообщение увидит только тот, кто ввел команду
                    context.getSource().sendMessage(Text.literal("§a[MyMod] §fФункция работает! Привет из кода!"));
                    return 1;
                }));
        });
    }
}
