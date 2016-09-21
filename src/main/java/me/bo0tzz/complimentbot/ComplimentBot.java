package me.bo0tzz.complimentbot;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * Created by bo0tzz on 21-9-2016.
 */
public class ComplimentBot {
    public final TelegramBot bot;

    public static void main(String[] args) {
        new ComplimentBot(args[0]);
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                //Lol just keep going
            }
        }
    }

    public ComplimentBot(String token) {
        this.bot = TelegramBot.login(token);
        bot.getEventsManager().register(new ComplimentBotListener(this));
        bot.startUpdates(false);
    }
}
