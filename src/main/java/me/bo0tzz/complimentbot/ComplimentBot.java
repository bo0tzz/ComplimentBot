package me.bo0tzz.complimentbot;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * Created by bo0tzz on 21-9-2016.
 */
public class ComplimentBot {
    public final TelegramBot bot;

    public static void main(String[] args) {
        String token = System.getenv("BOT_KEY");
        if (token == null || token.equals("")) {
            System.out.println("Supply a token!");
            System.exit(1);
        }
        new ComplimentBot(token);
    }

    public ComplimentBot(String token) {
        this.bot = TelegramBot.login(token);
        bot.getEventsManager().register(new ComplimentBotListener(this));
        bot.startUpdates(false);
    }
}
