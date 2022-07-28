package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.HomeController;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;
import com.spring.common.CommonUtil;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/board/boardList.do", method = RequestMethod.GET)
	public String boardList( Locale locale, Model model, BoardVo boardVo) throws Exception {
		
		String view = "board/boardList";
		
		// pageNo = 1로 세팅을 한다.
		int totalCnt = 0;
		if(boardVo.getPageNo() == 0) {
			boardVo.setPageNo(1);
		}
		
		// 체크를 한다면 view는 boarList_search를 거친다.
		if(boardVo.getSearchKey() != null) {
			view = "board/boardList_search";
		}
		
		List<BoardVo> boardList = boardService.boardList(boardVo);
		totalCnt = boardService.selectBoardCnt(boardVo);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCnt", totalCnt);
		
		// 체크박스 조회 체크 표시
		CodeVo codeVo = new CodeVo();
		codeVo.setCodeType("menu");
		List<CodeVo> codeList = boardService.codeList(codeVo);
		model.addAttribute("codeList", codeList);
		
		return view;
	}
	
	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardView.do", method = RequestMethod.GET)
	public String boardView( Locale locale, Model model
			,@PathVariable("boardType")String boardType
			,@PathVariable("boardNum")int boardNum) throws Exception {
		
		BoardVo boardVo = boardService.boardView(boardType, boardNum);
		
		model.addAttribute( "board", boardVo );
		
		return "board/boardView";	
	}
	
	@RequestMapping(value = "/board/{codeType}/{codeId}/boardWrite.do", method = RequestMethod.GET)
	public String boardWrite( Locale locale, Model model
			,@PathVariable("codeType")String codeType
			,@PathVariable("codeId")String codeId) throws Exception {
		
		// 체크박스 조회 체크 표시
		CodeVo codeVo = new CodeVo();
		codeVo.setCodeType("menu");
		List<CodeVo> codeList = boardService.codeList(codeVo);
		
		model.addAttribute("codeList", codeList);
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "/board/boardWriteAction.do", method = RequestMethod.POST)
	public String boardWriteAction( Locale locale, BoardVo boardVo) throws Exception {
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCnt = boardService.boardInsert(boardVo);
		
		result.put("success", (resultCnt > 0)? "Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ", result);
		
		System.out.println( "callbackMsg" + callbackMsg );
		
		return "board/boardWriteAction";
	}

	@RequestMapping(value = "/board/boardDeleteAction.do", method = RequestMethod.POST)
	public String boardDeleteAction( Locale locale,BoardVo boardVo) throws Exception {
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCnt = boardService.boardDelete(boardVo);
		
		result.put("success", (resultCnt > 0)? "Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ", result );
		
		System.out.println( "callbackMsg" + callbackMsg );
		
		return "board/boardDeleteAction";
	}
	
	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardUpdate.do", method = RequestMethod.GET)
	public String boardUpdate( Locale locale, Model model
			,@PathVariable("boardType")String boardType
			,@PathVariable("boardNum")int boardNum) throws Exception {
		
		BoardVo boardVo = boardService.boardView(boardType, boardNum);
		
		model.addAttribute( "boardType", boardType );
		model.addAttribute( "boardNum", boardNum );
		model.addAttribute( "board", boardVo );
		
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "/board/boardUpdateAction.do", method = RequestMethod.POST)
	public String boardUpdateAtion( Locale locale, Model model, BoardVo boardVo) throws Exception {
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCnt = boardService.boardUpdate(boardVo);
		
		result.put("success", (resultCnt > 0)? "Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ", result);
		
		System.out.println( "callbackMsg :" + callbackMsg );
		
		return "board/boardUpdateAction";
	}
}
