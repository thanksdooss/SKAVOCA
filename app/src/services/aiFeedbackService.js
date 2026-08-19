// AI Dynamic Distractor Comparison Service
import { api } from "./apiClient.js";

class AiFeedbackService {
  async getOrGenerateFeedback(word, userInput) {
    try {
      const { data } = await api.explainDistractor({
        wordId: word.wordId,
        wrongInput: userInput
      });

      return {
        feedback: data.feedback,
        isFromCache: data.isFromCache,
        isAiGenerated: true
      };
    } catch (e) {
      console.error("Failed to fetch AI feedback", e);
      return {
        feedback: {
          contrast: "AI 피드백 서버 오류로 불러오지 못했습니다.",
          correctConcept: `${word.term} : ${word.easyMeaning}`,
          practicalTip: "네트워크 상태를 확인해주세요.",
          isDynamic: true
        },
        isFromCache: false,
        isAiGenerated: false
      };
    }
  }
}

export const aiFeedbackService = new AiFeedbackService();
