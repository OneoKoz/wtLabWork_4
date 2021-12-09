package by.bsuir.kozyrev.controller.command.user;

import by.bsuir.kozyrev.controller.command.Command;
import by.bsuir.kozyrev.controller.command.CommandResult;
import by.bsuir.kozyrev.entity.Room;
import by.bsuir.kozyrev.exception.ServiceException;
import by.bsuir.kozyrev.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> freeRoomList = roomService.findFree();
        request.setAttribute(ROOM_LIST, freeRoomList);
        return CommandResult.forward(MAIN_PAGE);
    }
}
