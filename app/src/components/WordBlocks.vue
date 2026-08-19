<template>
  <div class="word-blocks-container">
    <div class="blocks-hint">💡 터치하여 단어를 조립하세요 (모바일 최적화)</div>
    <div class="blocks-grid">
      <button
        v-for="block in availableBlocks"
        :key="block.id"
        :class="['block-btn', { used: isUsed(block.id) }]"
        :disabled="isUsed(block.id)"
        @click="selectBlock(block)"
      >
        {{ block.text }}
      </button>
    </div>

    <!-- Clear / Backspace helper -->
    <div class="block-controls" v-if="selectedBlocks.length > 0">
      <button class="backspace-btn" @click="removeLastBlock">
        ⌫ 한 글자 지우기
      </button>
      <button class="clear-btn" @click="clearAll">
        전체 지우기
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";

const props = defineProps({
  blocks: {
    type: Array,
    default: () => []
  },
  modelValue: {
    type: String,
    default: ""
  }
});

const emit = defineEmits(["update:modelValue", "submit"]);

const availableBlocks = ref([]);
const selectedBlocks = ref([]);

watch(
  () => props.blocks,
  (newBlocks) => {
    availableBlocks.value = newBlocks || [];
    selectedBlocks.value = [];
  },
  { immediate: true }
);

function isUsed(blockId) {
  return selectedBlocks.value.some((b) => b.id === blockId);
}

function selectBlock(block) {
  if (isUsed(block.id)) return;
  selectedBlocks.value.push(block);
  syncValue();
}

function removeLastBlock() {
  selectedBlocks.value.pop();
  syncValue();
}

function clearAll() {
  selectedBlocks.value = [];
  syncValue();
}

function syncValue() {
  const isWordMode = selectedBlocks.value.some((b) => b.type === "word");
  const value = isWordMode
    ? selectedBlocks.value.map((b) => b.text).join(" ")
    : selectedBlocks.value.map((b) => b.text).join("");

  emit("update:modelValue", value);
}
</script>

<style scoped>
.word-blocks-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.75rem;
  margin-top: 1rem;
  width: 100%;
}

.blocks-hint {
  font-size: 0.8rem;
  color: #94a3b8;
  font-weight: 500;
}

.blocks-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 0.5rem;
  max-width: 480px;
}

.block-btn {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.15);
  color: #f8fafc;
  font-size: 1.05rem;
  font-weight: 700;
  padding: 0.6rem 0.9rem;
  border-radius: 8px;
  cursor: pointer;
  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.2);
  transition: all 0.15s ease;
  user-select: none;
}

.block-btn:hover:not(:disabled) {
  background: #334155;
  border-color: #38bdf8;
  transform: translateY(-2px);
}

.block-btn:active:not(:disabled) {
  transform: translateY(1px);
}

.block-btn.used {
  opacity: 0.25;
  cursor: not-allowed;
  transform: none;
  border-color: transparent;
}

.block-controls {
  display: flex;
  gap: 0.5rem;
  margin-top: 0.25rem;
}

.backspace-btn, .clear-btn {
  background: transparent;
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #94a3b8;
  font-size: 0.8rem;
  font-weight: 600;
  padding: 0.35rem 0.65rem;
  border-radius: 6px;
  cursor: pointer;
}

.backspace-btn:hover, .clear-btn:hover {
  color: white;
  border-color: rgba(255, 255, 255, 0.25);
}
</style>
