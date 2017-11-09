package me.bo0tzz.complimentbot;

import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputTextMessageContent;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultArticle;
import pro.zackpollard.telegrambot.api.event.Listener;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineQueryReceivedEvent;

/**
 * Created by bo0tzz on 21-9-2016.
 */
public class ComplimentBotListener implements Listener {
    private final ComplimentBot main;
    private final ComplimentManager manager;

    public ComplimentBotListener(ComplimentBot main) {
        this.main = main;
        this.manager = ComplimentManager.getInstance();
    }

    @Override
    public void onInlineQueryReceived(InlineQueryReceivedEvent event) {
        String compliment = manager.getCompliment();

        event.getQuery().answer(main.bot, InlineQueryResponse.builder()
                .results(InlineQueryResultArticle.builder()
                        .inputMessageContent(InputTextMessageContent.builder().messageText(compliment).build())
                        .title(compliment)
                        .build())
                .cacheTime(1)
                .build());
    }


}
